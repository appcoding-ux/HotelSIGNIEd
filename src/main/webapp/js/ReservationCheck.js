function ReservationCheck(){  
   if($('#num').val() == ""){
      alert("예약번호를 확인해주세요.");
   return false;
   }
  return true;
}