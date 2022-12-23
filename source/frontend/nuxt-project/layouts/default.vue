<template>
  <div>
  <nav class="navbar">
    <div class="navbar_logo">
      <nuxt-link to="/">
        <h1>Mobigen Github</h1>
      </nuxt-link>
    </div>
  </nav>
  <nuxt />
  </div>
</template>

<script type="text/javascript">
export default {
  name: "DefaultLayout"
};
</script>

<style scoped>
.navbar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background:#263343;
  padding: 8px 12px;
}

.navbar_logo {
  font-size: 24px;
  color: white;
}

</style>
