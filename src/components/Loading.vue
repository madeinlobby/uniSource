<template>
    <div>
        <div class="loading">
            <img src="../assets/3.gif" alt="لودینگ"/>
        </div>
    </div>
</template>

<script>

    export default {
        name: 'Loading',
        components: {
        }
    }
</script>

<style scoped>
    .loading {
        position: absolute;
        top: 0;
        left: 0;

        width: 100%;
        height: 100%;

        z-index: 1;

        display: flex;
        justify-content: center;
        align-items: center;
    }

    .loading img {
        width: 85px;
        height: 85px;
    }
</style>