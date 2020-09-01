<template>
    <div>
        <Loading :show="loading"/>
        <div v-show="!loading">
            <NavBar/>
            <div id="login-box">
                <b-container class="text-center">
                    <h3>Login</h3>
                    <br>
                    <div role="group">
                        <label class="mt-1"><b>Username:</b></label>
                        <b-form-input
                                v-model="username"
                                aria-describedby="input-live-help input-live-feedback"
                                placeholder="Enter your Username"
                                trim
                        ></b-form-input>

                        <label class="mt-2"><b>Password:</b></label>
                        <b-form-input
                                v-model="password"
                                type="password"
                                aria-describedby="input-live-help input-live-feedback"
                                placeholder="Enter your Password"
                                trim
                        ></b-form-input>

                        <b-form-checkbox
                                id="checkbox-1"
                                v-model="rememberMe"
                                name="checkbox-1"
                                value="accepted"
                                unchecked-value="not_accepted"
                                class="mt-2"
                        >
                            Remember me
                        </b-form-checkbox>

                        <b-button variant="primary" class="mt-3 mb-2" @click="login">Login</b-button>
                        <div>
                            <h6 class="mb-1">Don't have an account?</h6>
                            <b-link to="sign-up">Register!</b-link>
                        </div>
                    </div>
                </b-container>
            </div>
        </div>
        <div v-show="loading">
            <Loading/>
        </div>
    </div>
</template>

<script>
    import NavBar from "@/components/NavBar";
    import Loading from "@/components/Loading"
    import {loginUrl} from "@/links";

    export default {
        name: "Login",
        components: {
            NavBar,
            Loading
        },
        data() {
            return {
                username: '',
                password: '',
                rememberMe: false,
                loading: false
            }
        },
        methods: {
            login() {
                this.loading = true
                window.axios.post(loginUrl, {
                    username: this.username,
                    password: this.password
                }, {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }).then(response => {
                    this.loading = false
                    let jwt = sessionStorage.getItem('JWT')
                    jwt = response.data.jwt
                    sessionStorage.setItem('JWT', jwt)
                    this.$bus.$emit('logged', 'User logged')
                    this.$router.push('/')
                })
                    .catch(err => {
                        console.log(err)
                        this.loading = false
                    })
            }
        }
    }
</script>

<style scoped>
    .text-center {
        margin-top: 3%;
        width: 300px;
    }
</style>