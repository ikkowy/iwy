<template>
  <div class="pa-3 d-flex flex-column ga-3">
    <iwy-breadcrumbs :breadcrumbs="breadcrumbs" />

    <div class="pa-1 d-flex flex-wrap ga-2">
      <v-btn class="text-none" prepend-icon="mdi-plus" variant="flat" @click="showLocationEditDialog = true">
        {{ i18n.t('global.label.add') }}
        <v-tooltip activator="parent" location="bottom">
          Add new location
        </v-tooltip>
      </v-btn>
      <v-btn class="text-none" prepend-icon="mdi-delete-outline" variant="flat">
        {{ i18n.t('global.label.remove') }}
        <v-tooltip activator="parent" location="bottom">
          Remove selected locations
        </v-tooltip>
      </v-btn>
      <v-btn class="text-none" prepend-icon="mdi-filter-outline" variant="flat">
        {{ i18n.t('global.label.filter') }}
        <v-tooltip activator="parent" location="bottom">
          Configure table filter
        </v-tooltip>
      </v-btn>
      <v-btn class="text-none" prepend-icon="mdi-table-cog" variant="flat">
        {{ i18n.t('global.label.columns') }}
        <v-tooltip activator="parent" location="bottom">
          Configure table columns
        </v-tooltip>
      </v-btn>
      <v-btn class="text-none" prepend-icon="mdi-database-import-outline" variant="flat">
        {{ i18n.t('global.label.import') }}
        <v-tooltip activator="parent" location="bottom">
          Import locations from a file in CSV, XML, or JSON formats
        </v-tooltip>
      </v-btn>
      <v-btn class="text-none" prepend-icon="mdi-database-export-outline" variant="flat">
        {{ i18n.t('global.label.export') }}
        <v-tooltip activator="parent" location="bottom">
          Export locations to a file in CSV, XML, or JSON formats
        </v-tooltip>
      </v-btn>
    </div>

    <div class="pa-2">
      <v-data-table
        :headers="headers"
        hover
        :items="entries"
        :loading="loading"
        @update:options="fetchTableData"
      />
    </div>
  </div>

  <LocationEditDialog v-model:show="showLocationEditDialog" />
</template>

<script setup lang="ts">
import { useI18n } from 'vue-i18n';

import { getLocations } from '@/utils/api/LocationApiUtils';
import { LocationDTO } from '@/dto/LocationDTO';

const i18n = useI18n();

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

const loading = ref(false);

const entries = ref<LocationDTO[]>([]);

const headers = [
  {
    key: 'name',
    sortable: true,
    title: 'Name'
  },
  {
    key: 'description',
    sortable: true,
    title: 'Description'
  }
];

function fetchTableData({ page, itemsPerPage, sortBy }: { page: number, itemsPerPage: number, sortBy: any }) {
  loading.value = true;

  console.log('page', page);
  console.log('itemsPerPage', itemsPerPage);

  if (sortBy.length) {
    console.log({ key: sortBy[0].key, order: sortBy[0].order });
  }

  getLocations().then(value => {
    entries.value = value;
  });

  loading.value = false;
}
</script>
