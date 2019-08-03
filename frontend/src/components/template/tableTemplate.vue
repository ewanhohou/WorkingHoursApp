<template>
<div>
    <table id="example" class="table table-striped table-bordered" style="width:100%">
        <thead>
            <tr>
                <th v-for="(item, index) in tableData.title" v-bind:key="index">{{item}}</th>
                <th v-if="show"></th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="(row, i) in tableData.rows" v-if="i >= showTr[0] && i < showTr[1]" v-bind:key="i">
                <td v-for="(item, j) in row" v-if="j != 'id'" v-bind:key="j">{{item}}</td>
                <td class="action" v-if="show">
                    <router-link :to="{name:`${$route.path}/modify/:id`, params:{id:row.id}}" class="btn">
                        <i class="fa fa-pencil"></i>
                    </router-link>
                    <a title="刪除" class="btn" @click.stop.prevent="deleteMethod(row, i)">
                        <i class="fa fa-times text-red"></i>
                    </a>
                </td>
            </tr>
        </tbody>
    </table>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item" :class="{disabled: currPage == 1}"><a class="page-link" href="#" @click.stop.prevent="prePage">上頁</a></li>
            <li class="page-item" :class="{active: currPage == page }" v-for="page in pages" v-bind:key="page"><a class="page-link" href="#" @click.stop.prevent="click(page)">{{page}}</a></li>
            <li class="page-item" :class="{disabled: currPage == pages}"><a class="page-link" href="#" @click.stop.prevent="nextPage">下頁</a></li>
        </ul>
    </nav>
</div>
</template>

<script>
export default {
    name: 'tableTemplate',
    props: {
        tableData: Object,
        show: Boolean
    },
    data() {
        return {
            pages: 0,
            pageSize: 5,
            showTr: [0, 5],
            currPage: 1,
        };
    },
    watch: {
        'tableData.rows'(data) {
            this.pages = Math.ceil(data.length / this.pageSize);
        }
    },
    methods: {
        deleteMethod(row, i) {
            if (!confirm('確定要刪除嗎？')) return;
            this.$emit('deleteMethod', row, i)
        },
        click(page) {
            this.currPage = page;
            this.showTr = [(page - 1) * this.pageSize, page * this.pageSize];
        },
        prePage() {
            if (this.currPage != 1) this.currPage--;
            this.click(this.currPage);
        },
        nextPage() {
            if (this.currPage != this.pages) this.currPage++;
            this.click(this.currPage);
        },
    }
}
</script>

<style lang="scss" scoped>
#example {
    width: 100vw;
    padding: 10px;
}

nav {
    text-align: right;

    .pagination {
        margin: 0px;
    }
}

.action {
    width: 76px;
    padding: 0px;
}
</style>
