<?php
include_once "koneksi.php";

	class usr{}

	$pilihpc = $_POST["pilihpc"];
	$tanggal = $_POST['tanggal'];
    $tanggal = date('Y-m-d H:i:s',strtotime($tanggal));

	if ((empty($pilihpc))) {
		$response = new usr();
		$response->success = 0;
		$response->message = "Pilihan Pc tidak boleh kosong";
		die(json_encode($response));
	} else if ((empty($tanggal))) {
		$response = new usr();
		$response->success = 0;
		$response->message = "Pilih Tanggal tidak boleh kosong";
		die(json_encode($response));
	} else {
		if (!empty($pilihpc)){
			$num_rows = mysqli_num_rows(mysqli_query($con, "SELECT * FROM list_booking WHERE booking_pc='".$pilihpc."'"));

			if ($num_rows == 0){
				$query = mysqli_query($con, "INSERT INTO list_booking SET booking_pc='$pilihpc', tanggal_booking='$tanggal'");

				if ($query){
					$response = new usr();
					$response->success = 1;
					$response->message = "Booking berhasil, silahkan cek di list Booking.";
					die(json_encode($response));

				} else {
					$response = new usr();
					$response->success = 0;
					$response->message = "Pc sudah ada yang booking";
					die(json_encode($response));
				}
			} else {
				$response = new usr();
				$response->success = 0;
				$response->message = "Pc sudah ada yang Booking";
				die(json_encode($response));
			}
		}
	}

	mysqli_close($con);
?>