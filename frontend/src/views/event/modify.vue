<template>
<div>
    <modifyTemplate title="工時" :method="method">
        <form @submit.prevent="popup" class="form-horizontal">
            <selectValid label="客戶" :options="customers" v-model="form.cusId"></selectValid>
            <selectValid label="雇員" :options="employees" v-model="form.empId"></selectValid>
            <dateTimePicker ref="dt" @setStartTime="setStartTime" @setEndTime="setEndTime" v-model="form.startTime" :startTimeOld="form.startTime" :endTimeOld="form.endTime"></dateTimePicker>
            <button type="submit" id="submit" class="btn pull-right margin bg-maroon">送出</button>
        </form>
    </modifyTemplate>
    <modalTemplate ref="popup" title="確認" @submit="submit">
        <div class="table-responsive">
            <table class="table">
                <tbody>
                    <tr>
                        <th class="top" style="width:50%">客戶:</th>
                        <td class="top">{{cusName ? cusName.name : cusName}}</td>
                    </tr>
                    <tr>
                        <th>雇員</th>
                        <td>{{empName ? empName.name : empName}}</td>
                    </tr>
                    <tr>
                        <th>起始日期</th>
                        <td>{{form.startTime | dateTime}}</td>
                    </tr>
                    <tr>
                        <th>結束日期</th>
                        <td>{{form.endTime | dateTime}}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </modalTemplate>
</div>
</template>

<script>
import {
    api
} from '@/resource';
import modifyTemplate from '@/components/template/modifyTemplate';
import modalTemplate from '@/components/template/modalTemplate';
import selectValid from '@/components/validations/selectValid';
import dateTimePicker from '@/components/validations/dateTimePickerValid';
import moment from 'moment'

import {
    modify
} from "@/mixins";

export default {
    name: 'modify',
    data() {
        return {
            method: '新增',
            customers: [],
            employees: [],
            form: {
                empId: null,
                cusId: null,
                startTime: '',
                endTime: ''
            }
        };
    },
    components: {
        modifyTemplate,
        modalTemplate,
        selectValid,
        dateTimePicker
    },
    filters: {
        dateTime: function (value) {
            if (value) {
                return moment(String(value)).format('DD-MM-YYYY HH:mm')
            }
        }
    },
    mixins: [modify],
    mounted() {
        this.axios.all([
                this.get(),
                this.getCustomersRequest(),
                this.getEmployeesRequset()
            ])
            .then(this.axios.spread((get_response, cus_response, emp_response) => {
                this.customers = cus_response.data.map(m => {
                    return {
                        slug: m.cusId,
                        name: m.name,
                    };
                });
                if (this.form.cusId == null) this.form.cusId = this.customers[0].slug;
                this.employees = emp_response.data.map(m => {
                    return {
                        slug: m.empId,
                        name: m.name,
                    };
                });
                if (this.form.empId == null) this.form.empId = this.employees[0].slug;
            })).catch(this.$handleError);
    },
    computed: {
        cusName: function () {
            return this.customers.find(f => f.slug === this.form.cusId);
        },
        empName: function () {
            return this.employees.find(f => f.slug === this.form.empId);
        }
    },
    methods: {
        popup() {
            if (this.$refs.dt.require()) this.$refs.popup.show();
        },
        getCustomersRequest() {
            return api('customers')
        },
        getEmployeesRequset() {
            return api('employees')
        },
        setStartTime(dateTime) {
            this.form.startTime = dateTime;
        },
        setEndTime(dateTime) {
            this.form.endTime = dateTime;
        },
        submit() {
            !this.$route.params.id ? this.create() : this.modify();
            this.$refs.popup.hide();
        },
        create() {
            this.post('events');
        },
        modify() {
            this.put('events', this.$route.params.id);
        },
        get() {
            if (this.$route.params.id) {
                this.method = "修改";
                return api(`events/${this.$route.params.id}`).then(res => {
                    this.form = {
                        empId: res.data.emp.empId,
                        cusId: res.data.cus.cusId,
                        startTime: res.data.startTime,
                        endTime: res.data.endTime,
                    }
                }).catch(this.$handleError);
            }
        },
    },
}
</script>

<style lang="scss" scoped>
.form-group {
    margin-bottom: 15px;
}

.bg-maroon {
    background-color: #3c8dbc !important;
}
</style>
