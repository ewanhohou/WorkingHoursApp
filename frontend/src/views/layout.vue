<template>
<div>
    <header class="main-header">
        <a href="/" class="logo">
            <span class="logo-mini"><b>工時</b></span>
            <span class="logo-lg"><b>工時</b>計算系統</span>
        </a>
        <nav class="navbar navbar-static-top" role="navigation">
            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <li class="dropdown user user-menu">
                        <!-- <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            <span class="hidden-xs">Lulu</span>
                        </a>
                        <ul class="dropdown-menu" style="width:0px;min-width:100px;right:0%;">
                            <li class="user-footer">
                                <a title="修改密碼" data-click="changePassword" class="btn btn-default btn-flat" style="padding:5px">修改密碼</a>
                                <a href="" class="btn btn-default btn-flat" style="color:black;padding:5px">登出</a>
                            </li>
                        </ul> -->
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <aside class="main-sidebar">
        <section class="sidebar">
            <ul class="sidebar-menu" data-widget="tree">
                <li>
                    <router-link to="/customers"><i class="fa fa-circle-o"></i><span>客戶管理</span></router-link>
                </li>
                <li>
                    <router-link to="/employees"><i class="fa fa-circle-o"></i><span>雇員管理</span></router-link>
                </li>
                <li>
                    <router-link to="/events"><i class="fa fa-circle-o"></i><span>工時管理</span></router-link>
                </li>
                <li>
                    <router-link to="/wages"><i class="fa fa-circle-o"></i><span>薪資</span></router-link>
                </li>
            </ul>
        </section>
    </aside>
    <router-view></router-view>
</div>
</template>

<script>
export default {
    name: 'layout',
}
</script>

<style lang="scss">
.main-header {
    border-top: 6px solid #3c8dbc;
}

@media (max-width: 767px) {
    .main-header {
        border-top: 0;
    }
}

.main-sidebar>.sidebar {
    padding-top: 8px !important;
}
</style>
