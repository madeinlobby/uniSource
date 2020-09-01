<template>
    <div>
        <Loading :show="loader"/>
        <b-navbar toggleable="sm" type="dark" variant="dark">
            <b-navbar-brand to="/"><img class="image" src="../assets/logo.png" alt="Logo"/></b-navbar-brand>

            <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

            <b-collapse id="nav-collapse" is-nav>
                <b-navbar-nav>
                    <b-nav-item v-show="!isUserLoggedIn" to="/login">Login</b-nav-item>
                    <b-nav-item v-show="!isUserLoggedIn" :disabled="isUserLoggedIn" to="sign-up">Register</b-nav-item>
                </b-navbar-nav>

                <!-- Right aligned nav items -->
                <b-navbar-nav v-show="isUserLoggedIn" class="ml-auto">
                    <b-nav-item-dropdown right>
                        <!-- Using 'button-content' slot -->
                        <template v-slot:button-content>
                            <em>User</em>
                        </template>
                        <b-dropdown-item href="#">Profile</b-dropdown-item>
                        <b-dropdown-item @click="signOut">Sign Out</b-dropdown-item>
                    </b-nav-item-dropdown>
                </b-navbar-nav>
            </b-collapse>
        </b-navbar>
    </div>
</template>

<script>
    import {checkTokenUrl, signOutUrl} from "@/links";
    import Loading from '@/components/Loading';

    export default {
        name: "NavBar",
        data() {
            return {
                isUserLoggedIn: true,
                loader: true
            }
        },
        components: {
            Loading
        }
        ,
        beforeCreate() {
            this.$bus.$on('logged', () => {
                this.isUserLoggedIn = true
            })
            window.axios.get(checkTokenUrl, {
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${sessionStorage.getItem('JWT')}`
                }
            }).then(res => res.data)
                .then(data => {
                    this.isUserLoggedIn = data
                    this.loader = false
                })
                .catch(err => console.log(err))
        },
        methods: {
            signOut() {
                this.loader = true
                window.axios.get(signOutUrl, {
                    headers: {
                        'Content-Type': 'application/json',
                        'Authorization': `Bearer ${sessionStorage.getItem('JWT')}`
                    }
                    // eslint-disable-next-line no-unused-vars
                }).then(response => {
                    sessionStorage.setItem('JWT', '');
                    this.isUserLoggedIn = false
                    this.loader = false
                    window.location.reload();
                }).catch(err => console.log(err))
            }
        }
    }
</script>

<style scoped>
    .image {
        width: 150px;
        height: 40px;
    }
</style>