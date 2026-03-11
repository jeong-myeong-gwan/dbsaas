<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="footer">
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
        </div>
    </footer>

    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Create the tabs -->
        <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
            <li class="active"><a href="#contol-sidebar-config-tab" data-toggle="tab" aria-expanded="true"><i class="fa fa-wrench"></i></a></li>
            <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
            <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
        </ul>
        <!-- Tab panes -->
        <div class="tab-content">
            <!-- theme demo option tab content -->
            <div class="tab-pane active" id="contol-sidebar-config-tab">
                <h3 class="control-sidebar-heading"><i class="fa fa-fw fa-angle-right"></i>연회비 관련 설정</h3>
                <ul class="control-sidebar-menu">
                    <li>
                        <a href="http://osk.mj/admin/content/setting/policy/fiscal_date.php">
                            <h4 class="control-sidebar-subheading">연회비 기준날짜</h4>
                        </a>
                    </li>
                    <li>
                        <a href="http://osk.mj/admin/content/setting/fee/item_list.php">
                            <h4 class="control-sidebar-subheading">비용 항목 관리</h4>
                        </a>
                    </li>
                    <li>
                        <a href="http://osk.mj/admin/content/setting/fee/user_class_list.php">
                            <h4 class="control-sidebar-subheading">회원 등급 관리</h4>
                        </a>
                    </li>
                    <li>
                        <a href="http://osk.mj/admin/content/setting/fee/product_list.php">
                            <h4 class="control-sidebar-subheading">회비 항목 관리</h4>
                        </a>
                    </li>
                </ul>
            </div>
            <!-- Home tab content -->
            <div class="tab-pane" id="control-sidebar-home-tab">
                <h3 class="control-sidebar-heading">관리자</h3>
                <ul class="control-sidebar-menu">
                    <li>
                        <a href="http://osk.mj/admin/content/setting/admin_site/admin_list.php">
                            <h4 class="control-sidebar-subheading">관리자 관리</h4>
                        </a>
                    </li>
                </ul>
            </div>
            <!-- /.tab-pane -->
            <!-- Settings tab content -->
            <div class="tab-pane" id="control-sidebar-settings-tab">
                <ul class="control-sidebar-menu">
                    <li>
                        <a href="http://osk.mj/admin/content/setting/menu/menu.php">
                            <h4 class="control-sidebar-subheading">관리자 메뉴  관리</h4>
                        </a>
                    </li>
                    <li>
                        <a href="http://osk.mj/admin/content/setting/board/board_list.php">
                            <h4 class="control-sidebar-subheading">게시판 관리</h4>
                        </a>
                    </li>
                    <li>
                        <a href="http://osk.mj/admin/content/conf/mail_svr.php">
                            <h4 class="control-sidebar-subheading">메일서버 관리</h4>
                        </a>
                    </li>
                </ul>
            </div>
            <!-- /.tab-pane -->
        </div>
    </aside>
    <!-- /.control-sidebar -->

</div>
<!-- ./wrapper -->

<script>
    $(function() {
        $("#lnb-expand").click(function() {
            $("li.treeview").addClass("menu-open");
            $("ul.treeview-menu").css("display", "block");
        });
        $("#lnb-reduce").click(function() {
            $("ul.treeview-menu").css("display", "none");
            $("li.treeview").removeClass("menu-open");
        });

        // 항상 메뉴 확장 상태로
// 		$("li.treeview").addClass("menu-open");
// 		$("ul.treeview-menu").css("display", "block");

        var classID = $("li.treeview").find(".active").attr("id");
        $("ul." + classID).css("display", "block");

    });
</script>
</div>
