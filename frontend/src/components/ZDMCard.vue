<template>
  <div class="card llcard has-text-centered">
    <figure class="image avatar">
      <img id="profile-pic" class="is-rounded" :src="ppic" />
    </figure>
            <div class="label lname">
          {{ name }}
        </div>
        <a class="button is-green tm" :href="link"
          >View Profile</a
        >
  </div>
</template>

<script>
export default {
  name: "ZDMCard",
  props: ["ppic", "name", "id","link"],
};
</script>

<style scoped>
.tm{
  margin-bottom: 5%;
}
.llcard {
  width: 90%;
  margin: 5% auto;
}
.avatar {
  width: 8vmax;
  height: 8vmax;
  position: relative;
  display: block;
  margin: 5% auto 8% auto;
}
#profile-pic {
  position: absolute;
  object-fit: cover;
  object-position: center;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  width: 100%;
  height: 100%;
}
</style>