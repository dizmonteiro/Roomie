<template>
  <div>
    <tenant-navbar />
    <div class="columns">
      <div class="column is-full has-text-centered">
        <h1 class="title is-1">Applications</h1>
      </div>
    </div>
      <div id="scroll-area"  v-if="applications.length!==0">
        <smooth-scrollbar>
          <tenant-application 
            v-for="ap in applications"
            :key="ap.id"
            :application="ap"
            @cancel="takeOut(ap)"
          />
        </smooth-scrollbar>
      </div>
      <div v-else>
          <img class="empty" src="https://www.pngrepo.com/png/157995/180/empty-white-box.png">
      </div>
  </div>
</template>

<script>
import TenantApplication from "../components/TenantApplication.vue";
import TenantNavbar from "../components/TenantNavbar.vue";

export default {
  components: { TenantNavbar, TenantApplication },
  methods: {
    takeOut(x) {
      for (var i = 0; i < this.applications.length; i++) {
        if (this.applications[i] === x) {
          this.applications.splice(i, 1);
        }
      }
    },
  },
  data() {
    return {
        ww:window.innerWidth,
        wh:Window.innerHeight,
        applicationsx:[],
      applications: [
        {
            id:0,
          date: "01/01/2021",
          houseName: "Apartamento T0+1",
          houseLocation: "Braga",
          status: "Waiting for landlord confirmation",
          housePhotos: [
            "https://picsum.photos/id/164/1080/720",
            "https://picsum.photos/id/163/1080/720",
            "https://picsum.photos/id/308/1080/720",
            "https://picsum.photos/id/322/1080/720",
            "https://picsum.photos/id/351/1080/720",
            "https://picsum.photos/id/369/1080/720",
            "https://picsum.photos/id/398/1080/720",
          ],
        },
        {
            id:1,
          date: "01/02/2021",
          houseName: "Apartamento T0+1",
          houseLocation: "Braga",
          status: "Waiting for landlord confirmation",
          housePhotos: [
            "https://picsum.photos/id/164/1080/720",
            "https://picsum.photos/id/163/1080/720",
            "https://picsum.photos/id/308/1080/720",
            "https://picsum.photos/id/322/1080/720",
            "https://picsum.photos/id/351/1080/720",
            "https://picsum.photos/id/369/1080/720",
            "https://picsum.photos/id/398/1080/720",
          ],
        },
        {
            id:2,
          date: "01/03/2021",
          houseName: "Apartamento T0+1",
          houseLocation: "Braga",
          status: "Waiting for landlord confirmation",
          housePhotos: [
            "https://picsum.photos/id/164/1080/720",
            "https://picsum.photos/id/163/1080/720",
            "https://picsum.photos/id/308/1080/720",
            "https://picsum.photos/id/322/1080/720",
            "https://picsum.photos/id/351/1080/720",
            "https://picsum.photos/id/369/1080/720",
            "https://picsum.photos/id/398/1080/720",
          ],
        },
      ],
    };
  },
};
</script>

<style scoped>
.empty{
    margin: 0 auto;
    width: 35%;
}
.title{
  margin: 3% auto 0 auto;
}
.sCard {
  margin: 1% auto;
}
 #scroll-area {
   margin: 2% auto;
    width: 100%;
    height: 650px;
  }
</style>