//데이터 건증에 사용할 정규표현식
let regUid 		= /^[a-z]+[a-z0-9]{4,19}$/g;
let regName 	= /^[가-힣]{2,4}$/;
let regNick		= /^[가-힣a-zA-Z0-9]+$/;
let regEmail 	= /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
let regHp 		= /^\d{3}-\d{3,4}-\d{4}$/;
let regPass 	= /^.*(?=^.{5,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;

// 폼 데이터 검증 결과 상태변수
let isUidOK 	= false;
let isPassOK 	= false;
let isPassMatch = false;
let isNameOK 	= false;
let isNickOK 	= false;
let isEmailOK 	= false;
let isHpOK 		= false;

$(function(){
	
	//ID 중복확인
	$('input[name=uid]').keydown(function(){
		isUidOK = false;
		$('.resultUid').text('');
	});
	
	$('#btnUidCheck').click(function(){

		let uid = $('input[name=uid]').val();
		
		// ID 유효성
		if(isUidOK) return;
		if(!uid.match(regUid)){
			isUidOK = false;
			$('.resultUid').css('color', 'red').text('아이디가 유효하지 않습니다.')
			return;
		}
		
		// 중복
		$.ajax({
			url: '/Farmstory/user/checkUid',
			method: 'get',
			data: {"uid": uid},
			dataType: 'json',
			success:function(data){
				if(data.result > 0){
					$('.resultUid').css('color', 'red').text('이미 사용중인 아이디 입니다.');
				}else{
					$('.resultUid').css('color', 'blue').text('사용가능한 아이디 입니다.');
				}
			}
		});
	});
	//ID 중복확인 끝
	
	//비밀번호 중복
	$('input[name=pass1], input[name=pass2]').keydown(function(){
		$('.resultPass').text('');
	});
	$('input[name=pass1], input[name=pass2]').focusout(function(){
		const pass1 = $('input[name=pass1]').val();
		const pass2 = $('input[name=pass2]').val();
		
		//중복
		if(pass1!==pass2) {
			isPassMatch = false;
			$('.resultPass').css('color','red').text('비밀번호가 일치하지 않습니다.');
			return;
		}else{
			isPassMatch = true;
			$('.resultPass').css('color','green').text('비밀번호가 일치합니다.');
		}
		
		//유효성
		if(pass2.match(regPass)){
			isPassOK = true;
		}else{
			isPassOK = false;
			$('.resultPass').css('color','red').text('영문, 숫자, 특수문자 조합 최소5자 이상이여야 합니다.');
		}
	});
	//비밀번호 중복 끝
	
	//이름
	$('input[name=name]').focusout(function(){
		let name = $(this).val();
		if(!name.match(regName)){
			isNameOK = false;
			$('.nameResult').css('color','red').text('이름은 한글 2자 이상 이어야 합니다.');			
		}else{
			isNameOK = true;
			$('.nameResult').text('');
		}
	});
	//이름 끝
	
	// 휴대폰 유효성 검사
	$('input[name=hp]').focusout(function(){
		let hp = $(this).val();
		
		if(!hp.match(regHp)){
			isHpOK = false;
			$('.hpResult').css('color', 'red').text('휴대폰이 유효하지 않습니다.');
		}else{
			isHpOK = true;
			$('.hpResult').text('');
		}
	});
	//휴대폰 끝

	//별명 중복확인
    	$('input[name=nick]').keydown(function(){
    		isUidOK = false;
    		$('.resultUid').text('');
    	});

    	$('#btnNickCheck').click(function(){

    		let nick = $('input[name=nick]').val();

    		// 별명 유효성
    		if(isNickOK) return;
    		if(!nick.match(regNick)){
    			isNickOK = false;
    			$('.resultNick').css('color', 'red').text('별병이 유효하지 않습니다.')
    			return;
    		}

    		// 중복
    		$.ajax({
    			url: '/Farmstory/user/checkNick',
    			method: 'get',
    			data: {"nick": nick},
    			dataType: 'json',
    			success:function(data){
    				if(data.result > 0){
    					$('.resultNick').css('color', 'red').text('이미 사용중인 별명 입니다.');
    				}else{
    					$('.resultNick').css('color', 'blue').text('사용가능한 별명 입니다.');
    				}
    			}
    		});
    	});
    	//별명 중복확인 끝
});