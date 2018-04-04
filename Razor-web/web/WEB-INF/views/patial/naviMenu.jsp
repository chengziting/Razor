<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2018/3/29
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>

<script type="text/javascript">
    function selectNaviItem(id) {
        $("#"+id).addClass("active");
    }
</script>

<nav class="navbar navbar-default fullwidth">
    <%--<div class="container-fluid">--%>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <%--preference items--%>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        Preference <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">System Setting</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">About Razor</a></li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false" aria-haspopup="true">
                        Users&Roles<span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li id="main_menu_item_user_list"><a href="../users/list">Users Management</a> </li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Roles Management</a> </li>
                    </ul>
                </li>
            </ul>
        </div>
    <%--</div>--%>
</nav>

