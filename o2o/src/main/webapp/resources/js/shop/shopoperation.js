/**
 * 
 */
$(function() {
	var initURL = "/o2o/shop/getshopinitinfo";
	var registerShopURL = "/o2o/shopadmin/registershop";
	getShopInitInfo();
	function getShopInitInfo() {
		$.getJSON(initURL, function(data) {
			if (data.success) {
				var tempHtml = '';
				var tempAreaHtml = '';
				data.shopCategoryList.map(function(item, index) {
					tempHtml += '<option data-id="' + item.shopCategoryId
							+ '">' + item.shopCategoryName + '</option>';
				});
				data.areaList.map(function(item, index) {
					tempAreaHtml += '<option data-id="' + item.areaId + '">'
							+ item.areaName + '</option>';
				});
				$('#shop-category').html(tempHtml);
				$('#area').html(tempAreaHtml);
			}
		})
	}
	;
	$('#submit').click(function() {
		var shop = {};
		shop.shopName = $('#shop-name').val();
		shop.shopAddr = $('#shop-addr').val();
		shop.phone = $('#shop-phone').val();
		shop.shopDesc = $('#shop-desc').val();
		shop.shopCategory = {
			shopCategoryId : $('#shop-category').find('option').not(function() {
				return !this.selected;
			}).data('id')
		};
		shop.area = {
			shopCategoryId : $('#area').find('option').not(function() {
				return !this.selected;
			}).data('id')
		};
		var shopImg=$('#shop-img')[0].files[0];
		var formData=new FormData();
		formData.append('shopImg',shopImg);
		formData.append('shopStr',JSON.stringify(shop));
		$.ajax({
			url:registerShopURL,
			type:'POST',
			data:formData,
			contentType:false,
			processData:false,
			cache:false,
			success:function(data){
				if(data.success){
					$.toast('提交成功!');
				}else{
					$.toast('提交失败!'+data.errMsg);
				}
			}
		});
		
	});
});