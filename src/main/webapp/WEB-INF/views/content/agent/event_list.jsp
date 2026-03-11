<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!-- ########################################################### body start ####################################################-->
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <body>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <div class="content-header">
        <h1>이벤트 리스트
        </h1>
    </div>

    <div class="content">
        <div class="box box-default">
            <div class="box-body">
                <form id="searchfrm" name="searchfrm" method="get" action="/agent/event/list">
					<!-- <input type="hidden" name="page" value="1"> -->
                   
                    <div class="row add-top">
                        <div class="col-md-12">
                            <label class="col-md-1 control-label"></label>
                            <div class="col-md-7">
                                <div class="input-group">
                                    <select name="instanceId" class="form-control">
        <option value="">전체</option>
        <c:forEach var="inst" items="${instances}">
            <option value="${inst.instanceId}"
                <c:if test="${instanceId == inst.instanceId}">selected</c:if>>
                ${inst.instanceName}
            </option>
        </c:forEach>
    </select>
                                    
                                    <span class="input-group-addon"></span>
                                    <select name="type" class="form-control">
        <option value="">전체</option>
        <c:forEach var="t" items="${eventTypes}">
            <option value="${t}" <c:if test="${type == t}">selected</c:if>>
                ${t}
            </option>
        </c:forEach>
    </select>
                                </div>
                            </div>
                            <div class="col-md-4">
								<button type="submit" class="btn btn-primary">검 색</button>
                            </div>
                        </div>
                    </div>
					
                    
                </form>
            </div><!-- /.box-body -->
            <div class="box-footer">
            </div>
        </div><!-- /.box -->

        <div class="box box-info">
            <div class="box-header">
                <h3 class="box-title">
                    Total : <span>${totalCount}</span> &nbsp;
                </h3>
                
            </div>
            
            <!-- /.box-header -->
            <form id="form-item-new">
                <input type="hidden" name="chk_word" id="chk_word">
                <div class="box-body table-responsive">

<table class="table table-hover">
<tr>
    <th>ID</th>
        <th>Instance</th>
        <th>Agent</th>
        <th>Type</th>
        <th>Seq</th>
        <th>Created At</th>
        <th>보기</th>
</tr>

<c:forEach var="e" items="${events}">
<tr>
    <td>${e.id}</td>
            <td>${e.instanceName}</td>
            <td>${e.agentId}</td>
            <td>${e.eventType}</td>
            <td>${e.seq}</td>
            <td>${e.createdAt}</td>
            <td>
                <a href="/agent/event/detail?id=${e.id}">
                    상세
                </a>
            </td>
</tr>
</c:forEach>

</table>

</div><!-- /.box-body -->



            </form>
            <div class="box-footer text-center">
                <ul class="pagination">
    <!-- "이전" 버튼 -->
    <c:if test="${startPage > 1}">
        <li class="page-item">
            <a class="page-link" 
               href="/agent/event/list?page=${startPage - 1}&instanceId=${instanceId}&type=${type}&size=${size}" 
               title="이전 페이지로">
                <i class="xi-angle-left"></i>
            </a>
        </li>
    </c:if>

    <!-- 페이지 번호 -->
    <c:forEach var="i" begin="${startPage}" end="${endPage}">
        <li class="page-item ${currentPage == i ? 'active' : ''}">
            <a class="page-link" 
               href="/agent/event/list?page=${i}&instanceId=${instanceId}&type=${type}&size=${size}">
                ${i}
            </a>
        </li>
    </c:forEach>

    <!-- "다음" 버튼 -->
    <c:if test="${endPage < totalPages}">
        <li class="page-item">
            <a class="page-link" 
               href="/agent/event/list?page=${endPage + 1}&instanceId=${instanceId}&type=${type}&size=${size}" 
               title="다음 페이지로">
                <i class="xi-angle-right"></i>
            </a>
        </li>
    </c:if>
</ul>

            </div>

            <!-- /.box-footer -->
        </div>
    </div>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->

<!-- jQueryUI -->
<script src="/js/jquery.form.min.js"></script>
<script src="/js/jquery-ui.min.js"></script>

<script>
  $(function (){
     $("#period_from").datepicker({
             dateFormat : "yy-mm-dd",
             dayNamesMin : ["일", "월", "화", "수", "목", "금", "토"],
             monthNamesShort : ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
             monthNames : ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
             showMonthAfterYear : true,
             changeYear : true,
             changeMonth : true,
             yearRange : "-100:+0",
             defaultDate: "0",
             numberOfMonths: 1,
             onClose: function(selectedDate) {
                  $("#period_to").datepicker("option", "minDate", selectedDate);
             }
        });
        $("#period_to").datepicker({
             dateFormat : "yy-mm-dd",
             dayNamesMin : ["일", "월", "화", "수", "목", "금", "토"],
             monthNamesShort : ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
             monthNames : ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
             showMonthAfterYear : true,
             changeYear : true,
             changeMonth : true,
             defaultDate: "0",
             numberOfMonths: 1,
             onClose: function(selectedDate) {
                  $("#period_from").datepicker("option", "maxDate", selectedDate);
             }
        });
  });
</script>
<!-- ########################################################### body end ####################################################-->
</body>
</html>