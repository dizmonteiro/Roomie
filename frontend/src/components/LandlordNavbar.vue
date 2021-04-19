<template>
  <nav class="navbar is-fixed-top" role="navigation" aria-label="main navigation">
    <div class="navbar-brand">
      <a class="navbar-item" href="/">
        <img src="https://bulma.io/images/bulma-logo.png" width="112" height="28">
      </a>

      <a role="button" class="navbar-burger" aria-label="menu" aria-expanded="false" data-target="navbarBasicExample">
        <span aria-hidden="true"></span>
        <span aria-hidden="true"></span>
        <span aria-hidden="true"></span>
      </a>
    </div>

    <div id="navbarBasicExample" class="navbar-menu">
      <div class="navbar-end">
        <div class="navbar-item">
          <div class="buttons">
            <a class="button navb">
             <strong>Check Applications</strong>
            </a>
            <a class="button navb">
              <strong>Add New House</strong>
            </a>
            <a class="button navb">
              <strong>My Houses</strong>
            </a>
          </div>
        </div>
      </div>
    </div>
  </nav>
</template>

<script>
export default {
  name: 'LandlordNavbar'
}
</script>
<style scoped>
strong{
  color:white
}
.navb{
  border-width: 0;
  background-color: rgba(1,1,1,0);
}
.navbar{
  background-color:#2D6A4f;
}
</style>
