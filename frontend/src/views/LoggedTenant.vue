<template>
  <div>
    <TenantNavbar />
        <div id="content">
          <div class="columns is-centered is-vcentered">
            <div class="column is-three-fifths">
              <div class="card" id="loggedtenantcard">

                <div class="card-content">
                    <div class="column adjust-hero is-one-quarter-desktop is-full-mobile is-full-tablet has-text-centered">
                        <HouseList title="Houses" />
                    </div>
                </div>

              </div>
            </div>
          </div>
        </div>
  </div>
</template>

<script>
import TenantNavbar from '@/components/TenantNavbar.vue';
import HouseList from "@/components/HouseList.vue";

export default {

  name: 'LoggedTenant',

  components: {
    HouseList,
    TenantNavbar,
  }
}
</script>

<style scoped>

  #content {
    margin: 3% auto;
    width: 100%;
  }

  #preview {
    min-height: 200px;
    max-height: 200px;
  }

  #filler {
    min-height: 90vh;
  }

  @media (max-width: 770px) {
    #loggedtenantcard{
        margin: 3% auto;
        min-height: 80vh;
    }
  }

  label { display:block }
  
</style>