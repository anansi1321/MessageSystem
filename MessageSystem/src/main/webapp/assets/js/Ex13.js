// checkInput
// checkResult

$(document).ready(function(){
	
	$('#checkInput').on('input', emailCheck);
	
});

// EX13. 아이디 중복체크
function emailCheck(){
	
	var input = $(this).val(); // 입력 값 가져오기

	$.ajax({
		url : 'emailCheck.do',
		data : {
			'email' : input
		},
		type : 'get',
		success : function(res){
			
			const p = $('#checkResult')
			
			if(res == 'true'){
				p.html('사용 가능 한 이메일 입니다.').css('color', 'green');
				
			}else{
				p.html('사용 불가능한 이메일 입니다.').css('color', 'red');
			}
			
		},
		error : function(e){
			alert('error');
		}
	});	
	
}