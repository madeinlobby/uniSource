import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import BootstrapVue from 'bootstrap-vue'

// Install BootstrapVue

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'


import Home from './components/Home'
import Login from './components/Login'
import Register from './components/Register'
import Loading from './components/Loading'
import EventBus from "@/EventBus";


Vue.prototype.$bus = EventBus


if(sessionStorage.getItem('JWT') === null)
    sessionStorage.setItem('JWT','')

window.axios = require('axios');

const routes = [
    {path: '/', component: Home},
    {path: '/login', component: Login},
    {path: '/sign-up', component: Register},
    {path: '/loading', component: Loading}
];

const router = new VueRouter({
    routes
});

Vue.config.productionTip = false;
Vue.use(BootstrapVue);
Vue.use(VueRouter);


new Vue({
    router,
    render: h => h(App),
}).$mount('#app')
