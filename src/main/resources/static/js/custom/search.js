
	function move(num){
		
		location.href='/stay/' + num;
		
	}//end of move

    $(document).ready(function () {

        var tomorrow = new Date();
        tomorrow.setDate(tomorrow.getDate() + 1);

        $('#check-in').datepicker({
            dateFormat: 'yy-mm-dd',
            minDate: new Date(),
            onClose: function () {
                $('#check-out').datepicker({
                    dateFormat: 'yy-mm-dd',
                    minDate: new Date($('#check-in').val())
                });
            }
        });

        $('#check-out').datepicker({
            dateFormat: 'yy-mm-dd',
            minDate: tomorrow
        });

    });