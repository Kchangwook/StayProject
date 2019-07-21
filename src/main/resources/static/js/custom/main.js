   $(document).ready(function () {

        $('body').backstretch([
            "img/basic/bg1.jpg",
            "img/basic/bg2.jpg",
            "img/basic/bg3.jpg"
        ], {duration: 10000, fade: 750});

        $('#check-in').datepicker({
            dateFormat: 'yy-mm-dd',
            onClose: function () {
                $('#check-out').datepicker({
                    dateFormat: 'yy-mm-dd',
                    minDate: new Date($('#check-in').val())
                });
            },
            minDate: new Date()
        });

        $('#check-out').on('click', function () {
            if ($('#check-in').val() == '') {
                alert('체크인을 먼저 입력해주세요.');
                $('#check-in').focus();
            }
        });
        
        $('#join-btn').on('click', function(){
        	if($('#warning').css('display','block')) {
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
