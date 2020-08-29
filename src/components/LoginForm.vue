<template>
    <div id="login-box">
        <b-container class="text-center">
            <h3>Login</h3>
            <br>
            <div role="group">
                <label  class="mt-1"><b>Username:</b></label>
                <b-form-input
                        v-model="username"
                        aria-describedby="input-live-help input-live-feedback"
                        placeholder="Enter your Username"
                        trim
                ></b-form-input>

                <label class="mt-2"><b>Password:</b></label>
                <b-form-input
                        v-model="password"
                        type = "password"
                        aria-describedby="input-live-help input-live-feedback"
                        placeholder="Enter your Password"
                        trim
                ></b-form-input>

                <b-form-checkbox
                        id="checkbox-1"
                        v-model="status"
                        name="checkbox-1"
                        value="accepted"
                        unchecked-value="not_accepted"
                        class = "mt-2"
                >
                    Remember me
                </b-form-checkbox>

                <b-button variant="primary" class = "mt-3 mb-2">Login</b-button>
                <div>
                    <b-list horizontal="md">
                        <b-list-item><h6 class="mb-1">Don't have an account?</h6></b-list-item>
                        <b-list-item><b-link href="#foo">Register!</b-link></b-list-item>
                    </b-list>
                </div>
            </div>
        </b-container>
    </div>
</template>

<script>
    export default {
        name: "LoginFrom",
        data() {
            return {
                username: '',
                firstName: '',
                lastName: '',
                password: '',
                repeatedPassword: ''

            }
        }, computed: {
            nameState() {
                return this.firstName.length > 2 ? true : false
            },lastNameState() {
                return this.lastName.length > 2 ? true : false
            }
            ,
            usernameAvailability() {
                return false;
                //todo
            },
            checkPassword() {
                return true;
                //todo
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