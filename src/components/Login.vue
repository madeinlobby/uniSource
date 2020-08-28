<template>
    <div>
        <NavBar/>
        <LoginForm/>
    </div>
</template>

<script>
    import NavBar from "@/components/NavBar";
    import LoginForm from "@/components/LoginForm";

    export default {
        name: "Login",
        components: {
            NavBar,
            LoginForm
        }
    }
</script>

<style scoped>

</style>