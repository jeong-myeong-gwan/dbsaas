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
        <h1>Instance Metric Chart
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
            
            
            
            
            <form method="get">

Instance
<select name="instanceId" class="form-control">

<c:forEach var="i" items="${instances}">
<option value="${i.instanceId}"
<c:if test="${i.instanceId == instanceId}">selected</c:if>>
${i.instanceName}
</option>
</c:forEach>

</select>

Metric

<select name="metric" class="form-control">

<option value="Threads_running"
<c:if test="${metric=='Threads_running'}">selected</c:if>>
Threads_running
</option>

<option value="Threads_connected"
<c:if test="${metric=='Threads_connected'}">selected</c:if>>
Threads_connected
</option>

<option value="Questions"
<c:if test="${metric=='Questions'}">selected</c:if>>
Questions
</option>

<option value="Slow_queries"
<c:if test="${metric=='Slow_queries'}">selected</c:if>>
Slow_queries
</option>

</select>

<button class="btn btn-primary" type="submit">조회</button>

</form>

<br>

<canvas id="metricChart" width="900" height="400"></canvas>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<script>

const labels = [
<c:forEach var="p" items="${series}">
"${p.time}",
</c:forEach>
];

const values = [
<c:forEach var="p" items="${series}">
${p.value},
</c:forEach>
];

const ctx = document.getElementById('metricChart');

new Chart(ctx, {

type: 'line',

data: {

labels: labels,

datasets: [{

label: "${metric}",

data: values,

borderColor: 'rgb(75, 192, 192)',

tension: 0.2

}]

},

options: {

responsive: true,

scales: {

y: {

beginAtZero: true

}

}

}

});

</script>
            
            
            
            
            
            
            
            
         <!-- /.box-footer -->
        </div>
    </div>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->


<!-- ########################################################### body end ####################################################-->
</body>
</html>    