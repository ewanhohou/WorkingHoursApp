import Vue from 'vue'
const publicDomain = './api';

export const api = Vue.axios.create({
    baseURL: `${publicDomain}`
});
