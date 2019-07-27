<template>
<table id="example" class="table table-striped table-bordered" style="width:100%">
    <thead>
        <tr>
            <th>Name</th>
            <th>Mobile</th>
            <th>Address</th>
            <th>Hour_wage</th>
            <th>m</th>
            <th>d</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Garrett Winters</td>
            <td>System Architect</td>
            <td>Edinburgh</td>
            <td>61</td>
            <td class="action" width="5px">
                <button type="button" class="mb-1 mt-1 mr-1 btn btn-default blue">
                    <i class="fa fa-pencil"></i>
                </button>

            </td>
            <td class="action" width="5px">
                <a title="刪除" data-click="serversRemove" data-id="@item.Id" class="btn">
                    <i class="fa fa-times text-red"></i>
                </a>
            </td>
        </tr>
        <tr>
            <td>Garrett Winters</td>
            <td>Accountant</td>
            <td>Tokyo</td>
            <td>61</td>
            <td class="action" width="5px">
                <a title="修改" data-click="modal" data-id="@item.Id" class="btn">
                    <i class="fa fa-pencil text-olive"></i>
                </a>
            </td>
            <td class="action" width="5px">
                <a title="刪除" data-click="serversRemove" data-id="@item.Id" class="btn">
                    <i class="fa fa-times text-red"></i>
                </a>
            </td>
        </tr>
        <tr>
            <td>Ashton Cox</td>
            <td>Junior Technical Author</td>
            <td>San Francisco</td>
            <td>61</td>
            <td class="action" width="5px">
                <a title="修改" data-click="modal" data-id="@item.Id" class="btn">
                    <i class="fa fa-pencil text-olive"></i>
                </a>
            </td>
            <td class="action" width="5px">
                <a title="刪除" data-click="serversRemove" data-id="@item.Id" class="btn">
                    <i class="fa fa-times text-red"></i>
                </a>
            </td>
        </tr>
    </tbody>
</table>
</template>

<script>
export default {
    name: 'tableTemplate',
    props: {
        tableData: Object,
    },
    data() {
        return {
            dt: null,
            title: [],
        };
    },
    mounted() {
        this.init();
    },
    methods: {
        init() {
            this.dt = $("#example").DataTable({
                pageLength: 5,
                // columns: vm.title,
                // data: vm.tableData.row,
                oLanguage: {
                    sInfo: "顯示第 _START_ 至 _END_ 項結果，共 _TOTAL_ 項",
                    sInfoEmpty: "顯示第 0 至 0 項結果，共 0 項",
                    sLengthMenu: "顯示 _MENU_ 項結果",
                    sSearch: "搜尋:",
                    oPaginate: {
                        sFirst: "首頁",
                        sPrevious: "上頁",
                        sNext: "下頁",
                        sLast: "末頁"
                    },
                    sLoadingRecords: "載入中...",
                    sProcessing: "處理中...",
                    sInfoFiltered: "(由 _MAX_ 項結果過濾)",
                    sZeroRecords: "沒有匹配結果"
                }
            });
        },
    }
}
</script>

<style lang="scss" scoped>
@import url("https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap.min.css");

#example {
    width: 100vw;
    padding: 5px;
}
</style>
