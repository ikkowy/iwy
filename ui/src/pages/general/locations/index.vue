<template>
  <div class="pa-3 d-flex flex-column ga-3">
    <div class="pa-1 d-flex flex-wrap ga-2">
      <v-btn
        v-for="(item, index) in buttons"
        :key="index"
        class="text-none"
        variant="flat"
        :prepend-icon="item.icon"
        @click="item.click"
      >
        {{ item.label }}
        <v-tooltip activator="parent" location="bottom">
          {{ item.tooltip }}
        </v-tooltip>
      </v-btn>
    </div>

    <iwy-breadcrumbs :breadcrumbs="breadcrumbs" />

    <div class="pa-2">
      <v-data-table-server
        hover
        :headers="tableHeaders"
        :items="tableItems"
        :items-length="100"
        :loading="tableLoading"
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

const buttons = [
  {
    icon: 'mdi-refresh',
    label: i18n.t('global.label.refresh'),
    tooltip: i18n.t('global.tooltip.refreshTable'),
    click: refresh,
  },
  {
    icon: 'mdi-plus',
    label: i18n.t('global.label.add'),
    tooltip: i18n.t('global.tooltip.addNewRecord'),
    click: () => showLocationEditDialog.value = true,
  },
  {
    icon: 'mdi-delete-outline',
    label: i18n.t('global.label.remove'),
    tooltip: i18n.t('global.tooltip.removeSelectedRecords'),
    click: () => {}
  },
  {
    icon: 'mdi-filter-outline',
    label: i18n.t('global.label.filter'),
    tooltip: i18n.t('global.tooltip.configureTableFilter'),
    click: () => {}
  },
  {
    icon: 'mdi-table-cog',
    label: i18n.t('global.label.columns'),
    tooltip: i18n.t('global.tooltip.configureTableColumns'),
    click: () => {}
  },
  {
    icon: 'mdi-database-import-outline',
    label: i18n.t('global.label.import'),
    tooltip: i18n.t('global.tooltip.importData'),
    click: () => {}
  },
  {
    icon: 'mdi-database-export-outline',
    label: i18n.t('global.label.export'),
    tooltip: i18n.t('global.tooltip.exportData'),
    click: () => {}
  }
];

const showLocationEditDialog = ref(false);

const tableLoading = ref(false);

const tableHeaders = [
  {
    key: 'name',
    sortable: true,
    title: 'Name',
  },
  {
    key: 'description',
    sortable: true,
    title: 'Description'
  }
];

const tableItems = ref<LocationDTO[]>([]);

function fetchTableData({ page, itemsPerPage, sortBy }: { page: number, itemsPerPage: number, sortBy: any }) {
  tableLoading.value = true;

  console.log('page', page);
  console.log('itemsPerPage', itemsPerPage);

  if (sortBy.length) {
    console.log({ key: sortBy[0].key, order: sortBy[0].order });
  }

  getLocations().then(value => {
    tableItems.value = value;
  });

  tableLoading.value = false;
}

function refresh() {
  // TODO: Implement
}
</script>
