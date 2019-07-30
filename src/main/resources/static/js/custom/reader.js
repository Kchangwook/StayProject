
	$('#cancel').on('click',function(){
		history.back();
	});
	
    $('#pf-img').on('click',function(){
        $('#pf-img-input').click();
    });

    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
                $('#pf-img').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }

    $('#pf-img-input').change(function(){
        readURL(this);
        }
    );