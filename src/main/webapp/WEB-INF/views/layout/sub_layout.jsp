<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko"
      xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>OPTICAL SOCIETY OF KOREA</title>

    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

    
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
    <!-- Google Font -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
    <!-- fullcalendar -->
    <link href="https://cdn.jsdelivr.net/npm/fullcalendar@6.1.15/index.global.min.css" rel="stylesheet">
   	<link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="/css/adminlte/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="/css/jquery-ui.min.css">
    
    <link rel="stylesheet" href="/css/custom.css">
    <link rel="stylesheet" href="/css/sub.css">

    <script src="/js/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/adminlte.min.js"></script>
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
    <script src="/js/postcode.js"></script>

</head>
<body class="hold-transition sidebar-mini skin-blue">

<div class="wrapper">

    <header class="main-header">
        <!-- Logo -->
        <a href="http://osk.mj/admin/dashboard.php" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>I</b>F</span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg">CMS</span>
        </a>

        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>

            <div class="fav-item-shortcut pull-left hide"><!-- 자주쓰는 메뉴 바로 가기-->
                <a href="" class="btn btn-info">회원관리</a>
            </div>

            <!-- Navbar Right Menu -->
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <!-- User Account: style can be found in dropdown.less -->
                    <li class="dropdown user user-menu">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <span class="hidden-xs">관리자</span>
                        </a>
                        <ul class="dropdown-menu">
                            <!-- Menu Footer-->
                            <li class="user-footer">
                                <div class="pull-left">
                                    <a href="http://osk.mj/admin/content/setting/password.php" class="btn btn-default btn-flat">비밀번호 변경</a>
                                </div>
                                <div class="pull-right">
                                    <a href="/admin/logout" class="btn btn-danger btn-flat">로그아웃</a>
                                </div>
                            </li>
                        </ul>
                    </li>
                    <!-- Control Sidebar Toggle Button -->
                    <li>
                        <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!-- Header -->
<div>
	<%@ include file="/WEB-INF/views/fragments/header.jsp" %>
</div>

<!-- Content -->
<div>
    <jsp:include page="${contentPage}" />
</div>

<!-- Footer -->
<div>
	<%@ include file="/WEB-INF/views/fragments/footer.jsp" %>
</div>
</body>
</html>
