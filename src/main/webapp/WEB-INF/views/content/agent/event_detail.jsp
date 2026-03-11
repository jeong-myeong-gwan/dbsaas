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
        <h1>이벤트 상세 정보
        </h1>
    </div>

    <div class="content">
        <div class="box box-default">
            <div class="box-body">
                
            </div><!-- /.box-body -->
            <div class="box-footer">
            </div>
        </div><!-- /.box -->

        <div class="box box-info">
            <div class="box-header">
                
            </div>
            
            
            
            <div class="box-body table-responsive">

			<table class="table table-hover">
            	<tr>
        <th>ID</th>
        <td>${event.id}</td>
    </tr>
    <tr>
        <th>Tenant ID</th>
        <td>${event.tenantId}</td>
    </tr>
    <tr>
        <th>Instance</th>
        <td>${event.instanceName} (${event.instanceId})</td>
    </tr>
    <tr>
        <th>Agent ID</th>
        <td>${event.agentId}</td>
    </tr>
    <tr>
        <th>TS</th>
        <td>${event.ts}</td>
    </tr>
    <tr>
        <th>SEQ</th>
        <td>${event.seq}</td>
    </tr>
    <tr>
        <th>Event Type</th>
        <td>${event.eventType}</td>
    </tr>
    <tr>
        <th>Created At</th>
        <td>${event.createdAt}</td>
    </tr>
            </table>
            <br>
            <h3>Payload (Pretty JSON)</h3>
<pre style="background:#f5f5f5; padding:15px; white-space:pre-wrap;">${prettyPayload}</pre>
			<br>
			<a href="javascript:history.back()">목록으로</a>
            </div>
            
            
            
            
            
            
            
            
            
            
            
            
            

            <!-- /.box-footer -->
        </div>
    </div>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->


<!-- ########################################################### body end ####################################################-->
</body>
</html>