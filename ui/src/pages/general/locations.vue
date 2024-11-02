<template>
  <div class="pa-3 d-flex flex-column ga-3">
    <iwy-breadcrumbs :breadcrumbs="breadcrumbs" />

    <div class="pa-1 d-flex flex-wrap ga-2">
      <v-btn class="text-none" prepend-icon="mdi-plus" variant="flat" @click="showLocationEditDialog = true">
        Add
        <v-tooltip activator="parent" location="bottom">
          Add new location
        </v-tooltip>
      </v-btn>
      <v-btn class="text-none" prepend-icon="mdi-delete-outline" variant="flat">
        Remove
        <v-tooltip activator="parent" location="bottom">
          Remove selected locations
        </v-tooltip>
      </v-btn>
      <v-btn class="text-none" prepend-icon="mdi-filter-outline" variant="flat">
        Filter
        <v-tooltip activator="parent" location="bottom">
          Configure table filter
        </v-tooltip>
      </v-btn>
      <v-btn class="text-none" prepend-icon="mdi-table-cog" variant="flat">
        Columns
        <v-tooltip activator="parent" location="bottom">
          Configure table columns
        </v-tooltip>
      </v-btn>
      <v-btn class="text-none" prepend-icon="mdi-database-import-outline" variant="flat">
        Import
        <v-tooltip activator="parent" location="bottom">
          Import locations from a file in CSV, XML, or JSON formats
        </v-tooltip>
      </v-btn>
      <v-btn class="text-none" prepend-icon="mdi-database-export-outline" variant="flat">
        Export
        <v-tooltip activator="parent" location="bottom">
          Export locations to a file in CSV, XML, or JSON formats
        </v-tooltip>
      </v-btn>
    </div>

    <div class="pa-2">
      <v-data-table hover :items="entries" />
    </div>
  </div>

  <LocationEditDialog v-model:show="showLocationEditDialog" />

</template>

<script setup lang="ts">
const entries = [
  {
    location: 'Berlin'
  },
  {
    location: 'Dresden'
  },
  {
    location: 'Leipzig'
  },
  {
    location: 'Stuttgart'
  }
];

const breadcrumbs = [
  {
    title: 'General',
    disabled: false,
    href: '/general'
  },
  {
    title: 'Locations',
    disabled: false,
    href: '/general/locations'
  }
];

const showLocationEditDialog = ref(false);
</script>
