<template>
    <div>
        <NavBar/>
        <div id="register-box">
            <b-container class="text-center">
                <h3>Register</h3>
                <br>
                <div role="group">
                    <div>
                        <label class="mt-1"><b>Username:</b></label>
                        <b-form-input
                                v-model="username"
                                :state="usernameAvailability"
                                aria-describedby="input-live-help input-live-feedback"
                                placeholder="Enter your name"
                                trim
                                @change="checkUsername"
                        ></b-form-input>
                        <b-form-invalid-feedback id="input-live-feedback">
                            Username is taken
                        </b-form-invalid-feedback>
                    </div>

                    <div>
                        <label class="mt-2"><b>Name:</b></label>
                        <b-form-input
                                v-model="firstName"
                                :state="nameState"
                                aria-describedby="input-live-help input-live-feedback"
                                placeholder="Enter your First Name"
                                trim
                        ></b-form-input>
                        <!-- This will only be shown if the preceding input has an invalid state -->
                        <b-form-invalid-feedback id="input-live-feedback">
                            Enter at least 3 letters
                        </b-form-invalid-feedback>
                    </div>

                    <div>
                        <label class="mt-2"><b>lastName:</b></label>
                        <b-form-input
                                v-model="lastName"
                                :state="lastNameState"
                                aria-describedby="input-live-help input-live-feedback"
                                placeholder="Enter your Last Name"
                                trim
                        ></b-form-input>
                        <b-form-invalid-feedback id="input-live-feedback">
                            Enter at least 3 letters
                        </b-form-invalid-feedback>
                    </div>

                    <label class="mt-2"><b>Password:</b></label>
                    <b-form-input
                            type="password"
                            :state="checkPassword"
                            v-model="password"
                            aria-describedby="input-live-help input-live-feedback"
                            placeholder="Password"
                            trim
                    ></b-form-input>
                    <div>
                        <label class="mt-2"><b>Confirm your password:</b></label>
                        <b-form-input
                                type="password"
                                :state="checkPassword"
                                v-model="repeatedPassword"
                                aria-describedby="input-live-help input-live-feedback"
                                placeholder="Confirm your password."
                                trim
                        ></b-form-input>
                        <b-form-invalid-feedback id="input-live-feedback">
                            Something is Wrong.
                        </b-form-invalid-feedback>
                    </div>
                    <b-button variant="primary" class="mt-3 mb-2"
                              :disabled="!(checkPassword && usernameAvailability && nameState && lastNameState)"
                              @click="signUp">
                        Sign-up
                    </b-button>
                    <div>
                        <h6 class="mb-1">Have an account?</h6>
                        <b-link to="/login">Sign in!</b-link>
                    </div>
                </div>
            </b-container>
        </div>
    </div>
</template>

<script>
    import NavBar from "@/components/NavBar";
    import {registerUrl} from "@/links";

    export default {
        name: "Register",
        components: {
            NavBar
        },
        data() {
            return {
                username: '',
                firstName: '',
                lastName: '',
                password: '',
                repeatedPassword: '',
                usernameAvailability: false,
            }
        }, computed: {
            nameState() {
                return this.firstName.length > 2 ? true : false
            }, lastNameState() {
                return this.lastName.length > 2 ? true : false
            },
            checkPassword() {
                if (this.password === '')
                    return false
                return this.password === this.repeatedPassword ? true : false
            }
        },
        methods: {
            checkUsername() {
                console.log(12);
                window.axios.get(`http://localhost:8081/auth/check-username/${this.username}`)
                    .then(response => (this.usernameAvailability = response.data));
            },
            signUp() {
                console.log(registerUrl)
                this.axios.post(registerUrl, {
                    username: this.username,
                    password: this.password,
                    firstName: this.firstName,
                    lastName: this.lastName,
                    roles: null
                }, {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }).then(response => {
                    console.log(response)
                    this.$router.push("/login")
                })
                    .catch(err => console.log(err))
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