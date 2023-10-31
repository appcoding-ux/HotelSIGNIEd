function ReservationCheck(){  
   if(document.frm.num.value.length == 0){
      alert("예약번호를 확인해주세요.");
   return false;
   }
  return true;

	if($('#num').val() == ""){
		alert("예약번호는 필수입력입니다.");
		return false;
	}
	return true;
}


function ReservationValue(){
	
	
	var email = userinput.email.value
		var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

			if(exptext.test(email)==false){

			//이메일 형식이 알파벳+숫자@알파벳+숫자.알파벳+숫자 형식이 아닐경우			

			alert("이메일형식이 올바르지 않습니다.");

			userinput.email.focus();

		return false;
	}
	return true;
}
