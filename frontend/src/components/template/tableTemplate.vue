<template>
<div>
    <table id="example" class="table table-striped table-bordered" style="width:100%">
        <thead>
            <tr>
                <th></th>
                <th v-for="(item, index) in tableData.title" v-bind:key="index">{{item}}</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(row, i) in tableData.rows" v-bind:key="i">
                <td v-for="(item, j) in row" v-bind:key="j">{{item}}</td>
                <td class="action">
                    <a title="修改" class="btn" @click="modifyMethod(row)">
                        <i class="fa fa-pencil"></i>
                    </a>
                </td>
                <td class="action">
                    <a title="刪除" class="btn" @click="deleteMethod(row)">
                        <i class="fa fa-times text-red"></i>
                    </a>
                </td>
            </tr>
        </tbody>
    </table>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="#">上頁</a></li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">下頁</a></li>
        </ul>
    </nav>
</div>
</template>

<script>
export default {
    name: 'tableTemplate',
    props: {
        tableData: Object,
    },
    data() {
        return {};
    },
    methods: {
        modifyMethod(item) {
            console.log(item);
        },
        deleteMethod() {},
    }
}
</script>

<style lang="scss" scoped>
#example {
    width: 100vw;
    padding: 5px;
}

nav {
    text-align: right;

    .pagination {
        margin: 0px;
    }
}

.action {
    width: 5px;
}
</style>
