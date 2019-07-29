<template>
    <section class="body-error error-inside">
        <div class="center-error">

            <div class="row">
                <div class="col-md-12">
                    <div class="main-error mb-xlg">
                        <h2 class="error-code text-dark text-center text-weight-semibold m-none">404
                            <i class="fa fa-file"></i>
                        </h2>
                        <p class="error-explanation text-center">We're sorry, but the page you were looking for doesn't exist.</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
</template>

<script>
export default {
  mounted() {
    this.$root.title = "找不到網頁";
  }
};
</script>