# gsc-multilingual-address-geocoding
###GeoSmartCity Multilingual Address Geocoding 

Multilingual Address Geocoding will be used to retrieve the location of one or more given addresses. The service will be used as input in the routing service between two addresses: given one or more addresses this service retrieves their location.

Address geocoding with multilingual support; the service uses OSM data model in order to allow users to search for an address inside the pilot area of interest. The multilingual address geocoding manage three possible results:

- no addresses matching input search criteria

- list of addresses matching input search criteria

- only one address matching the input address In the first option, the user will be prompted with an error message; in the second option, the user will see a list off addresses in which can be made a choice of the requested address.

If pilot area in OSM does not have building numbers along the street, the service will give just the street as output, and will retrive the coords street center point.

The service has support for multilingual searc, e.g. "Finnish: Köydenpunojankatu – English Koydenpunojankatu".

The service will retrive coords in the WGS84 coord system.

 

###Status

The development of the service has been completed.

 

###Funding

The development of Multilingual Address Geocoding is part-funded by the European Commission through the GeoSmartCity project

 

###Licence

Multilingual Address Geocoding service may be redistributed under the MIT LICENSE
