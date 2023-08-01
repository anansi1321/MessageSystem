// searchInput
// searchBtn
// tbd

$(document).ready(function(){
	
	$('#searchBtn').on('click', boardSearch);
	
});

// Ex14. 게시글 검색하기
function boardSearch(){
	
	$.ajax({
		url : "search.do",
		data : {
			"search" : $('#searchInput').val()
		},
		dataType : 'json', // json 데이터를 응답받아서 바로 쓰기 위해 필요
		type : "get",
		success : makeTable, 
		error : function(e){
			alert("error");
		}
	})
	
}

// json 데이터를 이용해 테이블 출력하기
function makeTable(json){
	
	const tbody = $('#tbd');
	
	tbody.html(''); // 테이블 초기화
	
	let tr = ``;
	
	for(let i = 0; i < json.length; i++){
		tr = `
			<tr>	
				<td>${json[i].idx}</td>
				<td>${json[i].title}</td>
				<td>${json[i].writer}</td>
				<td>${json[i].indate}</td>
			</tr>
		`; // 백틱을 이용한 작성법	
		tbody.append(tr);
	}
	
}






