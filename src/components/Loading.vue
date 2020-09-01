<template>
    <div>
                <b-overlay
                        no-wrap
                        id="overlay-background"
                        :show="show"
                        :variant="variant"
                        :opacity="opacity"
                        :blur="blur"
                        rounded="sm"
                >
                </b-overlay>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                variant: 'light',
                opacity: 0.85,
                blur: '2px',
                variants: [
                    'transparent',
                    'white',
                    'light',
                    'dark',
                    'primary',
                    'secondary',
                    'success',
                    'danger',
                    'warning',
                    'info',
                ],
                blurs: [
                    { text: 'None', value: '' },
                    '1px',
                    '2px',
                    '5px',
                    '0.5em',
                    '1rem'
                ]
            }
        },
        props: ['show']
    }
</script>