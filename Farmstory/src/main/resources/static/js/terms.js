$(function(){
		$('.next').click(function(){
			let isCheck1 = $('.ter').is(':checked');
			let isCheck2 = $('.pri').is(':checked');

			if(isCheck1 && isCheck2){
				return true;
			}else{
				alert("전체 '동의합니다.'를 체크해 주세요.");
				return false;
			}
		});
	});