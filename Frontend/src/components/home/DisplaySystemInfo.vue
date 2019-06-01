<template>
  <v-card >
    <v-container>
      <v-layout row>
        <v-icon medium>{{icon_type}}</v-icon>
        <v-card-title primary-title class="text-sm-center">
          <div>
            <span class="title font-weight-regular">{{info}}</span>
          </div>
        </v-card-title>
      </v-layout>
      <v-layout row>
        <v-card-text class=" text-sm-center font-weight-bold display-2">
          <div class="secondary white--text" >
            <span class="">{{number}}</span>
          </div>
        </v-card-text>
      </v-layout>
    </v-container>
  </v-card>
</template>

<script>
export default {
  props: {
    number: Number,
    info: String,
    icon_type: String
  }
};
</script>

<style>
</style>
