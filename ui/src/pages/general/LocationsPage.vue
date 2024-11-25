<template>
  <navigation-bar :breadcrumbs="breadcrumbs" />

  <div class="pa-3 d-flex flex-column">
    <div class="pa-1 d-flex flex-wrap ga-2">
      <!-- Button: Refresh -->
      <table-button
        icon="mdi-refresh"
        :label="i18n.t('global.label.refresh')"
        :tooltip="i18n.t('global.tooltip.refreshTable')"
        @click="refreshTable"
      />
      <!-- Button: Add -->
      <table-button
        icon="mdi-plus"
        :label="i18n.t('global.label.add')"
        :tooltip="i18n.t('global.tooltip.addNewRecord')"
        @click="refLocationEditDialog?.open()"
      />
      <!-- Button: Remove -->
      <table-button
        :disabled="selectedItems.length === 0"
        icon="mdi-delete-outline"
        :label="i18n.t('global.label.remove')"
        :tooltip="i18n.t('global.tooltip.removeSelectedRecords')"
      />
      <!-- Button: Filter -->
      <table-button
        icon="mdi-filter-outline"
        :label="i18n.t('global.label.filter')"
        :tooltip="i18n.t('global.tooltip.configureTableFilter')"
        @click="() => {}"
      />
      <!-- Button: Columns -->
      <table-button
        icon="mdi-table-cog"
        :label="i18n.t('global.label.columns')"
        :tooltip="i18n.t('global.tooltip.configureTableColumns')"
        @click="() => {}"
      />
      <!-- Button: Import -->
      <table-button
        icon="mdi-database-import-outline"
        :label="i18n.t('global.label.import')"
        :tooltip="i18n.t('global.tooltip.importData')"
        @click="() => {}"
      />
      <!-- Button: Export -->
      <table-button
        icon="mdi-database-export-outline"
        :label="i18n.t('global.label.export')"
        :tooltip="i18n.t('global.tooltip.exportData')"
        @click="() => {}"
      />
    </div>

    <div class="pa-2">
      <v-data-table-server
        v-model="selectedItems"
        density="comfortable"
        :headers="tableHeaders"
        hover
        item-value="uuid"
        :items="tableItems"
        :items-length="tableItemsLength"
        :loading="tableLoading"
        show-select
        @click:row="handleTableRowClick"
        @update:options="updateOptions"
      />
    </div>
  </div>

  <location-edit-dialog
    ref="location-edit-dialog"
    @success="refreshTable"
  />
</template>

<script setup lang="ts">
import { ref, useTemplateRef } from 'vue';
import { useI18n } from 'vue-i18n';

import NavigationBar from '@/components/NavigationBar.vue';
import TableButton from '@/components/TableButton.vue';
import LocationEditDialog from '@/components/general/LocationEditDialog.vue';

import { LocationDTO } from '@/types/dto/LocationDTO';
import { getLocations } from '@/utils/api/LocationApiUtils';

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

const refLocationEditDialog = useTemplateRef('location-edit-dialog');

const tableLoading = ref(false);

const tableHeaders = [
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

const tableItems = ref<LocationDTO[]>([]);

const tableItemsLength = ref<number>(0);

const selectedItems = ref([]);

const tableOptions = ref();

function updateOptions(options: { page: number, itemsPerPage: number, sortBy: any }) {
  tableOptions.value = options;
  refreshTable();
}

function refreshTable() {
  if (tableOptions.value) {
    tableLoading.value = true;
    getLocations(
      tableOptions.value.page - 1,
      tableOptions.value.itemsPerPage,
      tableOptions.value.sortBy.length
        ? { key: tableOptions.value.sortBy[0].key, order: tableOptions.value.sortBy[0].order }
        : undefined
    ).then(response => {
      tableItems.value = response.content;
      tableItemsLength.value = response.totalElements;
    });
    tableLoading.value = false;
  }
}

function handleTableRowClick(_: PointerEvent, row: any): void {
  const uuid = row.item.uuid;
  if (typeof uuid === 'string') {
    refLocationEditDialog.value?.open(uuid);
  }
}
</script>
