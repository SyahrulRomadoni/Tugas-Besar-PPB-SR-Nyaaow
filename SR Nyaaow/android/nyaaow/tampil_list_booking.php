<?php  
 include_once "koneksi.php";
 $hasil         = mysqli_query($con, "SELECT * FROM list_booking") or die(mysqli_error());
 $json_response = array();
 
if(mysqli_num_rows($hasil)> 0){
 while ($row = mysqli_fetch_array($hasil)) {
     $json_response[] = $row;
 }
 echo json_encode(array('booking' => $json_response));
} 
?>