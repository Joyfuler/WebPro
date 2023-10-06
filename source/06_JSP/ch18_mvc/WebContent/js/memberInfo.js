/**
 * 회원정보 유효성을 검사하는 함수 submitChk()
 */
const infoConfirm = function(){
	const frm = document.getElementsByTagName('form')[0];
	const id = document.getElementsByName('id')[0];
	const pw = document.getElementsByName('pw')[0];
	const pwChk = document.getElementsByName('pwChk')[0];
	const name = document.getElementsByName('name')[0];	
	if (id.value.length < 3){
		alert('아이디는 3글자 이상으로 입력해주세요');
		id.focus();
		return;
	}
	
	if (!pw.value){
		alert('비밀번호는 필수 입력사항입니다.');
		pw.focus();
		return;
	}
	if (pw.value != pwChk.value){
		alert('비밀번호를 확인해주세요');
		pw.value = '';
		pwChk.value = '';
		pw.focus();
		return;
	}
	
	if (!name.value){
		alert('이름을 입력해주세요');
		name.focus();
	}
	frm.submit();
};