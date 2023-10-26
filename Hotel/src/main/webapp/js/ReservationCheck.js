function ReservationCheck(){  
   if(document.frm.num.value.length == 0){
      alert("예약번호를 확인해주세요.");
   return false;
   }
  return true;
}