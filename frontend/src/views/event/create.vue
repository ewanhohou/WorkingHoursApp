<template>
<addTemplate title="工時">
    <div class="form-horizontal">
        <selectValid label="客戶" :options="customers" v-model="form.cusId"></selectValid>
        <selectValid label="雇員" :options="employees" v-model="form.empId"></selectValid>
        <dateTimePicker label="起始日期" @dateTimeChangEvent="setStartTime"></dateTimePicker>
        <dateTimePicker label="結束日期" @dateTimeChangEvent="setEndTime"></dateTimePicker>
        <button type="submit" id="submit" class="btn btn-default pull-right" @click.stop.prevent="create()">送出</button>
    </div>
</addTemplate>
</template>

<script>
import {
    api
} from "@/resource";
import addTemplate from "@/components/template/addTemplate";
import selectValid from "@/components/validations/selectValid";
import dateTimePicker from "@/components/validations/dateTimePickerValid";

export default {
    name: 'create',
    data() {
        return {
            customers: [],
            employees: [],
            form: {
                empId: '',
                cusId: '',
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
    mounted() {
        this.axios.all([
                this.getCustomersRequest(),
                this.getEmployeesRequset()
            ])
            .then(this.axios.spread((first_response, second_response) => {
                this.customers = first_response.data.map(m => {
                    return {
                        slug: m.cusId,
                        name: m.name,
                    };
                });
                this.form.cusId = this.customers[0].slug;
                this.employees = second_response.data.map(m => {
                    return {
                        slug: m.empId,
                        name: m.name,
                    };
                });
                this.form.empId = this.employees[0].slug;
            }))
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
        create() {
            api.post('events', this.form, {
                headers: {
                    'Content-Type': 'application/json'
                }
            }).then(res => {
                if (res.status == 201) this.$router.push({
                    path: '/event'
                })
            })
        }
    },
}
</script>

<style lang="scss" scoped>
.form-group {
    margin-bottom: 15px;
}
</style>
