<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>
  Hamonize Cloud Service | Support List
  </title>
</head>
<%@ include file="../template/top2.jsp" %>

<body class="g-sidenav-show bg-gray-100">
  <input type="hidden" id="pageTitle" value="기술지원 관리">
  <input type="hidden" id="pageSubTitle" value="기술지원 내역">

  <div class="position-absolute w-100 min-height-300 top-0" style="background-color: #5e72e4;">
    <span class="mask bg-primary opacity-6"></span>
  </div>
  <%@ include file="../template/aside.jsp" %>


  <div class="main-content position-relative max-height-vh-100 h-100">
    <!-- Navbar -->
    <%@ include file="../template/navbar.jsp" %>
    <!-- End Navbar -->


    <div class="card shadow-lg mx-4 card-profile-bottom">
        <div class="card-body p-3">
            <div class="table-responsive">
                    <table class="table align-items-center mb-0">
                    <thead>
                        <tr>
                        <th class="text-uppercase text-secondary text-xs font-weight-bolder opacity-7">제목</th>
                        <th class="text-uppercase text-secondary text-xs font-weight-bolder opacity-7 ">분류</th>
                        <th class="text-center text-uppercase text-secondary text-xs font-weight-bolder opacity-7">상태</th>
                        <th class="text-center text-uppercase text-secondary text-xs font-weight-bolder opacity-7">신청일</th>
                        <th class="text-secondary opacity-7"></th>
                        </tr>
                    </thead>
                    <tbody>
                      <c:forEach items="${list}" var="list" varStatus="status" >

                            <tr>
                                <td>
                                    <div class="d-flex px-2 py-1">
                                        <div class="d-flex flex-column justify-content-center">
                                            <h6 class="mb-0 text-xs">${list.title}</h6>
                                        </div>
                                    </div>
                                </td>
                                <td id="aa" class="align-middle text-start">
                                    <span class="badge badge-sm badge-secondary ">${list.type}
                                        <c:if test="${list.type eq 1 } ">
                                            결제문의
                                        </c:if>
                                        <c:if test="${list.type eq 2} ">
                                            기술문의
                                        </c:if><c:if test="${list.type eq 3} ">sadas
                                            기타문의
                                        </c:if>
                                    </span>
                                </td>
                            

                                
                                <td class="align-middle text-center">
                                    <span class="badge badge-sm badge-secondary">처리중</span>
                                </td>
                                <td class="align-middle text-center">
                                <div id="aa">
                                    <input type="hidden" id="insdate" value="${list.insdate}">
                                    <span class="text-secondary text-xs font-weight-bold">  </span>
                                </div>

                                  
                                </td>
                                <td class="align-middle">
                                    <a href="/support/view?seq=${list.seq}" class="text-secondary font-weight-bold text-xs" data-toggle="tooltip" data-original-title="Edit user">
                                    수정
                                    </a>
                                        | 
                                    <a href="#!" class="text-secondary font-weight-bold text-xs" data-toggle="tooltip" data-original-title="Edit user">
                                    삭제
                                    </a>

                                </td>
                            </tr>
                        </c:forEach>

                    </tbody>
                    </table>
                </div>


        </div>

    </div>
  
  </div>

  
</body>

<%@ include file="../template/core.jsp" %>


<script>

$(document).ready(function () {
var insdate = $("#insdate").val();

console.log("insdate > "+ $("#aa input").val() );
let date = new Date($("#aa input").val());
console.log("insdate > "+date.getFullYear()+"/"+date.getMonth()+"/"+date.getDate());


insdate = date.getFullYear()+"/"+date.getMonth()+"/"+date.getDate();
  $("#aa span").text(insdate);  

});

</script>
</html>