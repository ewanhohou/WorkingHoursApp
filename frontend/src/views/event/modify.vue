<template>
<addTemplate title="工時">
    <div class="form-horizontal">
        <selectValid label="客戶" :options="customers" v-model="form.cusId"></selectValid>
        <selectValid label="雇員" :options="employees" v-model="form.empId"></selectValid>
        <dateTimePicker label="起始日期" @dateTimeChangEvent="setStartTime" v-model="form.startTime"></dateTimePicker>
        <dateTimePicker label="結束日期" @dateTimeChangEvent="setEndTime" v-model="form.endTime"></dateTimePicker>
        <button type="submit" id="submit" class="btn btn-default pull-right" @click.stop.prevent="submit()">送出</button>
    </div>
</addTemplate>
</template>

<script>
import {
    api
} from '@/resource';
import addTemplate from '@/components/template/addTemplate';
import selectValid from '@/components/validations/selectValid';
import dateTimePicker from '@/components/validations/dateTimePickerValid';
import {
    modify
} from "@/mixins";

export default {
    name: 'modify',
    data() {
        return {
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
        addTemplate,
        selectValid,
        dateTimePicker
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
    methods: {
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
            if (!this.$route.params.id) this.create();
            else this.modify();
        },
        create() {
            this.post('events');
        },
        modify() {
            this.put('events', this.$route.params.id);
        },
        get() {
            if (this.$route.params.id)
                return api(`events/${this.$route.params.id}`).then(res => {
                    this.form = {
                        empId: res.data.emp.empId,
                        cusId: res.data.cus.cusId,
                        startTime: res.data.startTime,
                        endTime: res.data.endTime,
                    }
                }).catch(this.$handleError);
        },
    },
}
</script>

<style lang="scss" scoped>
.form-group {
    margin-bottom: 15px;
}
</style>
