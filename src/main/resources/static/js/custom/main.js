   $(document).ready(function () {

        $('body').backstretch([
            "img/basic/bg1.jpg",
            "img/basic/bg2.jpg",
            "img/basic/bg3.jpg"
        ], {duration: 10000, fade: 750});

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
        
        $('#join-btn').on('click', function(){
        	if($('#warning').css('display','block') == true) {
        		alert('이메일이 중복되었습니다.');
        		return false;
        	}
        	else $('#join-frm').submit();
        });
        
        $('#join-email').on('blur', function(){
        	
        	$.ajax({
        		
        		url:'/member/check/' + $(this).val(),
        		type:'get',
        		success: function(data){
        			if(data == true) $('#warning').css('display','block');
        			else $('#warning').css('display','none');
        		}
        		
        	});
        	
        });

    });
