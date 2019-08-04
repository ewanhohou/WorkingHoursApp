<template>
<div>
    <modifyTemplate title="客戶" :method="method">
        <form @submit.prevent="popup" class="form-horizontal">
            <inputText ref="name" label="姓名" id="Name" v-model="form.name"></inputText>
            <inputTel ref="mobile" label="電話" id="Mobile" v-model="form.mobile"></inputTel>
            <inputText ref="address" label="地址" id="Address" v-model="form.address"></inputText>
            <button type="submit" id="submit" class="btn pull-right margin bg-maroon">確認</button>
        </form>
    </modifyTemplate>
    <modalTemplate ref="popup" title="確認" @submit="submit">
        <div class="table-responsive">
            <table class="table">
                <tbody>
                    <tr>
                        <th class="top" style="width:50%">姓名:</th>
                        <td class="top">{{form.name}}</td>
                    </tr>
                    <tr>
                        <th>電話</th>
                        <td>{{form.mobile}}</td>
                    </tr>
                    <tr>
                        <th>地址</th>
                        <td>{{form.address}}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </modalTemplate>
</div>
</template>

<script>
import modifyTemplate from '@/components/template/modifyTemplate';
import modalTemplate from '@/components/template/modalTemplate';
import inputText from '@/components/validations/inputTextValid';
import inputTel from '@/components/validations/inputTelValid';
import {
    modify
} from '@/mixins';

export default {
    name: 'modify',
    data() {
        return {
            method: '',
            form: {
                name: '',
                mobile: '',
                address: ''
            }
        };
    },
    components: {
        modifyTemplate,
        modalTemplate,
        inputText,
        inputTel
    },
    mixins: [modify],
    mounted() {
        this.$route.params.id ? this.get() : this.method = "新增";
    },
    methods: {
        popup() {
            const name = this.$refs.name.require();
            const mobile = this.$refs.mobile.require();
            const address = this.$refs.address.require();
            if (name && address && mobile) {
                this.$refs.popup.show();
            }
        },
        submit() {
            !this.$route.params.id ? this.create() : this.modify();
            this.$refs.popup.hide();
        },
        create() {
            this.post('customers');
        },
        modify() {
            this.put('customers', this.$route.params.id);
        },
        get() {
            this.method = "修改";
            this.getOne('customers', this.$route.params.id);
        }
    }
};
</script>

<style lang="scss" scoped>
.form-group {
    margin-bottom: 15px;
}

.top {
    border-top: 0px;
}

.bg-maroon {
    background-color: #3c8dbc !important;
}
</style>
