var menu = 1;
var search = 0;
var post = 0;
let map;
var markers = []
var geocoder;

$(document).ready(function() {
	// 시작하자마자 전체 데이터를 로드 해서 데이터를 업데이트
	//loadDataHome(0, '');
	updateMainSite(0);
	geocoder = new google.maps.Geocoder();
	// 로그인 버튼
	$('#loginModal #login').click(function(){
		if(!$('#loginModal #loginID').val()){
			alert('아이디를 입력하세요')
			return;
		}
		if(!$('#loginModal #loginPassword').val()){
			alert('비밀번호를 입력하세요')
			return;
		}
		$.ajax({
			url:'json/personData.json',
			dataType:'json',
			success:function(jsonData){
				var check = false;
				$.each(jsonData,function(index, item){
					if(item.id == $('#loginModal #loginID').val()){
						check = true;
						if(item.password == $('#loginModal #loginPassword').val()){
							alert('로그인 완료');
							$('#header .loginX').each(function(index, item){
								$(item).css('display','none');
							});
							$('#header .loginO').each(function(index, item){
								$(item).css('display','');
							});
							$('#ID').text(item.name);
							return;
						} else{
							alert('비밀번호가 틀립니다');
							return;
						}
					}
				});
				if(check == false){
					alert("없는 아이디 입니다.")
					return;
				}
			}
		})
	});
	
	// 회원 가입 버튼
	$('#joinModal #join').click(function(){
		if(!$('#joinModal #usrID').val()){
			alert('아이디를 입력하세요')
			return;
		}
		if(!$('#joinModal #usrPassword').val()){
			alert('비밀번호를 입력하세요')
			return;
		}
		if(!$('#joinModal #usrPasswordCheck').val()){
			alert('비밀번호 확인를 입력하세요')
			return;
		}
		if(!$('#joinModal #usrName').val()){
			alert('이름를 입력하세요')
			return;
		}
		
		if($('#joinModal #usrPassword').val() != $('#joinModal #usrPasswordCheck').val()){
			alert('비밀번호가 일치하지 않습니다.')
			return;
		}
		
		$.ajax({
			url:'json/personData.json',
			dataType:'json',
			success:function(jsonData){
				var check = false;
				$.each(jsonData,function(index, item){
					if(item.id == $('#joinModal #usrID').val()){
						check = true;
						alert('아이디가 중복됩니다.')
					}
				});
				
				if(check == false){
					alert("회원가입 완료")
					return;
				}
			}
		})
	})
	
	// 회원 정보 수정
	$('#personUpdateModal #Update').click(function(){
		if(!$('#personUpdateModal #puID').val()){
			alert('아이디를 입력하세요')
			return;
		}
		if(!$('#personUpdateModal #puPassword').val()){
			alert('비밀번호를 입력하세요')
			return;
		}
		if(!$('#personUpdateModal #puPasswordCheck').val()){
			alert('비밀번호 확인를 입력하세요')
			return;
		}
		if(!$('#personUpdateModal #puName').val()){
			alert('이름를 입력하세요')
			return;
		}
		
		if($('#personUpdateModal #puPassword').val() != $('#personUpdateModal #puPasswordCheck').val()){
			alert('비밀번호가 일치하지 않습니다.')
			return;
		}
		
		$.ajax({
			url:'json/personData.json',
			dataType:'json',
			success:function(jsonData){
				var check = false;
				$.each(jsonData,function(index, item){
					if(item.id == $('#personUpdateModal #puID').val()){
						check = true;
					}
				});
				
				if(check == false){
					alert("아이디가 없습니다.")
					return;
				} else{
					alert("회원 정보 변경 완료")
					return;
				}
			}
		})
	})
	
	// 회원 정보 삭제
	$('#personDeleteModal #Update').click(function(){
		if(!$('#personDeleteModal #pdID').val()){
			alert('아이디를 입력하세요')
			return;
		}
		if(!$('#personDeleteModal #pdPassword').val()){
			alert('비밀번호를 입력하세요')
			return;
		}
		if(!$('#personDeleteModal #pdPasswordCheck').val()){
			alert('비밀번호 확인를 입력하세요')
			return;
		}
		
		if($('#personDeleteModal #pdPassword').val() != $('#personDeleteModal #pdPasswordCheck').val()){
			alert('비밀번호가 일치하지 않습니다.')
			return;
		}
		
		$.ajax({
			url:'json/personData.json',
			dataType:'json',
			success:function(jsonData){
				var check = false;
				$.each(jsonData,function(index, item){
					if(item.id == $('#personDeleteModal #pdID').val()){
						check = true;
					}
				});
				
				if(check == false){
					alert("아이디가 없습니다.")
					return;
				} else{
					alert("회원 정보 삭제 완료")
					return;
				}
			}
		})
	})
	// 로그 아웃 버튼
	$('#logout').click(function(){
		$('#header .loginX').each(function(index, item){
			$(item).css('display','');
		});
		$('#header .loginO').each(function(index, item){
			$(item).css('display','none');
		});
	});
	
	$('#findPasswordbtn').click(function(){
		if(!$('#findPassword #pfid').val()){
			alert('아이디를 입력하세요')
			return;
		}
		if(!$('#findPassword #pfemail').val()){
			alert('이메일을 입력하세요')
			return;
		}
		$.ajax({
			url:'json/personData.json',
			dataType:'json',
			success:function(jsonData){
				$.each(jsonData,function(index, item){
					var check = false;
					if(item.id == $('#findPassword #pfid').val()){
						if(item.email == $('#findPassword #pfemail').val()){
							alert(item.password);
						} else{
							alert("이메일이 일치하지 않습니다.")
						}
						check = true;
						return;
					}
				});
				if(check == false){
					alert("아이디가 없습니다.")
				}
				return;
			}
		})
	});
	
	
	// 검색기준 클릭


	// 게시판 관련 기능
	$('.newPost').click(function(){
		updateInfoSite(1)
	})
	
})


function updateMainSite(idx){
	$('#showData').css('display','none');
	//$('#personData').css('display','none');
	$('#mainInfo').css('display','none');
	$('#websiteInfo').css('display','none');
	$('#findPassword').css('display','none');
	$('#siteMap').css('display','none');
	if(idx == 0){
		$('#showData').css('display','');
	} else if(idx == 1){	
		//$('#personData').css('display','');
		//openPerson();
	} else if(idx == 2){
		$('#mainInfo').css('display','');
		console.log("B");
		document.getElementById("postSearch").action = "main.do?action=searchPost";
		document.getElementById("postSearch").submit();	
		console.log("C");
	} else if(idx == 3){
		$('#websiteInfo').css('display','');	
	} else if(idx == 4){
		$('#findPassword').css('display','');	
	} else if(idx == 5){
		$('#siteMap').css('display','');	
	}
}

function movePage(idx){
	$.ajax({
		url:'json/post.json',
		dataType:'json',
		success:function(data){
			$.each(data,function(index, item){
				console.log(item.isbn)
				if(idx == item.isbn){
					$('#Ttitle').text(item.title);
					$('#Tid').text(item.author);
					$('#Tcheck').text(item.check);
					$('#Tdate').text(item.date);
					$('#Tcontent').text(item.content);
				}
			})
			updateInfoSite(2);
		}
	})
}



function updateInfoSite(idx){
	$('#post-main').css('display','none');
	$('#post-write').css('display','none');
	$('#post-one').css('display','none');
	if(idx == 0){
		$('#post-main').css('display','');
	} else if(idx == 1){	
		$('#post-write').css('display','');
	} else if(idx == 2){
		$('#post-one').css('display','');	
	}
}


function openPerson(){
	$.ajax({
		url:'json/personData.json',
		dataType:'json',
		success:function(jsonData){
			var html = `<table class="table text-center"><thead>
				<tr>
				<th style="width:25%">ID</th>
				<th style="width:25%">Name</th>
				<th style="width:50%">E-mail</th>
				</tr>
				</thead>
				<tbody>
				`;
			$.each(jsonData,function(index, item){
				html += `<tr><th>${item.id}</th><th>${item.name}</th><th>${item.email}</th></tr>`;
			});
			html += `</tbody></table>`;
			$("#personDataList").html(html);
		}
	})
}

function searchChange(ser, tex){
	$('#searchStdName').text(tex);
	search = ser;
}


function initMap() {
	map = new google.maps.Map(document.getElementById("map"), {
		center: {
			lat: 37.5013068,
			lng: 127.037471
			},
		zoom: 13
	});
}

function geocodeAddress(string) {
  const address = string;
  geocoder.geocode({ address: address }, (results, status) => {
    if (status === "OK") {
      var mak = new google.maps.Marker({
        map: map,
        position: results[0].geometry.location,
      });
  	   markers.push(mak)
       map.setCenter(results[0].geometry.location);
    }
  });
}

function clearMarkers(){
	for(var i = 0, end = markers.length; i < end; i++){
		markers[i].setMap(null);
	}
}